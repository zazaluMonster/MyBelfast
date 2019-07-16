package com.c_service;

import com.a_pojo.Crew;
import com.f_exception.FirstLoginException;

public interface ICrewService extends BaseService<Crew> {
    public boolean auth(Crew crew);
    public String tokenResolve(Crew crew, boolean doForce) throws FirstLoginException;
    public boolean isCrewAlreadyExist(String crewName,String phoneNum,String mail);
    public int register(Crew crew);
}
