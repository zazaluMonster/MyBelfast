package com.c_service;

import com.a_pojo.Crew;
import com.d_dao.ICrewDao;
import com.f_exception.FirstLoginException;
import com.g_util.AvatarUtil;
import com.g_util.DateUtil;
import com.g_util.TokenUtil;
import com.i_cache.EhcacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CrewService implements ICrewService {

    @Autowired
    private ICrewDao crewDao;

    /**
     * 验证账号密码是否正确
     * @param crew
     * @return
     */
    public boolean auth(Crew crew){
        Map<String,Object> condition = new HashMap<>();
        condition.put("item",crew);
        List<Crew> crews =  crewDao.selects(condition);
        if(crew == null || crews.size() <= 0){
            return false;
        }
        return true;
    }

    /**
     * Token登录处理
     */
    public String tokenResolve(Crew crew, boolean doForce) throws FirstLoginException {
        String key = crew.getCrewName();

        String token = TokenUtil.getToken(key);

        if(EhcacheManager.contains(key)){
            if(doForce){
                EhcacheManager.removeCache(key);
            }else{
                return EhcacheManager.getCacheValue(key);
            }
        }

        EhcacheManager.addCache(crew.getCrewName(),token);

        return token;
    }

    public boolean isCrewAlreadyExist(String crewName,String phoneNum,String mail){
        Crew crew = new Crew();
        crew.setCrewName(crewName);
        if(auth(crew)){
            return true;
        }
        crew = new Crew();
        crew.setPhoneNum(phoneNum);
        if(auth(crew)){
            return true;
        }
        crew = new Crew();
        crew.setMail(mail);
        if(auth(crew)){
            return true;
        }
        return false;
    }

    public int register(Crew crew){
        crew.setAvatarUrl(AvatarUtil.getAvatarUrl(""));
        crew.setCreateTime(DateUtil.getTimeString(new Date()));

        List<Crew> crews = new ArrayList<>();
        crews.add(crew);
        inserts(crews);
        return crews.get(0).getId();
    }

    @Override
    public void inserts(List<Crew> items) {
        crewDao.inserts(items);
    }

    @Override
    public void delete(int id) {
        crewDao.delete(id);

    }

    @Override
    public void deletes(List<Integer> ids) {
        crewDao.deletes(ids);
    }

    @Override
    public void update(Crew item) {
        crewDao.update(item);
    }

    @Override
    public void updates(List<Crew> items) {
        crewDao.updates(items);
    }

    @Override
    public List<Crew> selects(Map<String, Object> condition) {
        return crewDao.selects(condition);
    }


}
