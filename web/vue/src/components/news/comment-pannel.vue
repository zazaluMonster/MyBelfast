<style scoped>
/* git评论 */
.gitment-root-container {
    margin: 19px 0;
}

.gitment-container {
    font-family: sans-serif;
    font-size: 14px;
    line-height: 1.5;
    color: #333;
    word-wrap: break-word;
}
.gitment-container * {
    box-sizing: border-box;
}
.gitment-header-container {
    margin: 19px 0;
}
.gitment-header-like-btn, .gitment-comment-like-btn {
    cursor: pointer;
}
.gitment-header-like-btn svg {
    vertical-align: middle;
    height: 30px;
}

svg:not(:root) {
    overflow: hidden;
}
a.gitment-header-issue-link, a.gitment-header-issue-link:visited {
    float: right;
    line-height: 30px;
    color: #666;
}

.gitment-container a, .gitment-container a:visited {
    cursor: pointer;
    text-decoration: none;
}
.gitment-comments-list {
    list-style: none;
    padding-left: 0;
    margin: 0 0 38px;
}
.gitment-comment, .gitment-editor-container {
    position: relative;
    min-height: 60px;
    padding-left: 60px;
    margin: 19px 0;
}

.gitment-comment-avatar, .gitment-comment-avatar-img, .gitment-comment-avatar, .gitment-editor-avatar-img, .gitment-editor-avatar svg {
    width: 44px;
    height: 44px;
    border-radius: 3px;
}
.gitment-comment-avatar, .gitment-editor-avatar {
    float: left;
    margin-left: -60px;
}
.gitment-comment-main, .gitment-editor-main {
    position: relative;
    border: 1px solid #CFD8DC;
    border-radius: 0;
}
.gitment-comment-like-btn svg {
    vertical-align: middle;
    height: 20px;
}
.gitment-comment-like-btn {
    float: right;
}
.gitment-editor-main::before, .gitment-comment-main::before {
    border-width: 8px;
    border-right-color: #CFD8DC;
}
.gitment-comment-header {
    margin: 12px 15px;
    color: #666;
    background-color: #fff;
    border-radius: 3px;
}
a.gitment-comment-name, a.gitment-comment-name:visited {
    font-weight: 600;
    color: #666;
}
.gitment-markdown {
    -ms-text-size-adjust: 100%;
    -webkit-text-size-adjust: 100%;
    line-height: 1.5;
    color: #333;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
    font-size: 16px;
    line-height: 1.5;
    word-wrap: break-word;
}

.gitment-comment-body {
    position: relative;
    margin: 12px 15px;
    overflow: hidden;
    border-radius: 3px;
}

.gitment-comment, .gitment-editor-container {
    position: relative;
    min-height: 60px;
    padding-left: 60px;
    margin: 19px 0;
}
.gitment-editor-avatar .gitment-github-icon {
    fill: #fff;
    background-color: #333;
}
.gitment-editor-main::before, .gitment-editor-main::after, .gitment-comment-main::before, .gitment-comment-main::after {
    position: absolute;
    top: 11px;
    left: -16px;
    display: block;
    width: 0;
    height: 0;
    pointer-events: none;
    content: "";
    border-color: transparent;
    border-style: solid solid outset;
}
.gitment-editor-header {
    padding: 0;
    margin: 0;
    border-bottom: 1px solid #CFD8DC;
}
.gitment-editor-tabs {
    margin-bottom: -1px;
    margin-left: -1px;
}
.gitment-editor-tab.gitment-selected {
    color: #333;
    background-color: #fff;
    border-color: #CFD8DC;
}

.gitment-editor-tab {
    display: inline-block;
    padding: 11px 12px;
    font-size: 14px;
    line-height: 20px;
    color: #666;
    text-decoration: none;
    background-color: transparent;
    border-width: 0 1px;
    border-style: solid;
    border-color: transparent;
    border-radius: 0;
    white-space: nowrap;
    cursor: pointer;
    user-select: none;
    outline: none;
}
.gitment-editor-body {
    margin: 0;
}
.gitment-container *:disabled {
    cursor: not-allowed;
}

.gitment-editor-body textarea {
    display: block;
    width: 100%;
    min-height: 150px;
    max-height: 500px;
    padding: 16px;
    resize: vertical;
    max-width: 100%;
    margin: 0;
    font-size: 14px;
    line-height: 1.6;
    background-color: #fff;
    color: #333;
    vertical-align: middle;
    border: none;
    border-radius: 0;
    outline: none;
    box-shadow: none;
    overflow: visible;
}
.gitment-editor-main::after, .gitment-comment-main::after {
    margin-top: 1px;
    margin-left: 2px;
    border-width: 7px;
    border-right-color: #fff;
}


.gitment-comments-init-btn:disabled, .gitment-editor-submit:disabled {
    color: rgba(255,255,255,0.75);
    background-color: #4DD0E1;
    box-shadow: none;
}
.gitment-editor-submit, .gitment-comments-init-btn {
    color: #fff;
    background-color: #00BCD4;
    position: relative;
    display: inline-block;
    padding: 7px 13px;
    font-size: 14px;
    font-weight: 600;
    line-height: 20px;
    white-space: nowrap;
    vertical-align: middle;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    background-size: 110% 110%;
    border: none;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
}
</style>
<template>
  <div>
    <Card class="card">
      <div id="container">
        <div lang="en-US" class="gitment-container gitment-root-container">
          <div>
            <div lang="en-US" class="gitment-container gitment-header-container">
              <span class="gitment-header-like-btn">
                <svg
                  class="gitment-heart-icon"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 50 50"
                >
                  <path
                    d="M25 39.7l-.6-.5C11.5 28.7 8 25 8 19c0-5 4-9 9-9 4.1 0 6.4 2.3 8 4.1 1.6-1.8 3.9-4.1 8-4.1 5 0 9 4 9 9 0 6-3.5 9.7-16.4 20.2l-.6.5zM17 12c-3.9 0-7 3.1-7 7 0 5.1 3.2 8.5 15 18.1 11.8-9.6 15-13 15-18.1 0-3.9-3.1-7-7-7-3.5 0-5.4 2.1-6.9 3.8L25 17.1l-1.1-1.3C22.4 14.1 20.5 12 17 12z"
                  />
                </svg>
                Like
                •
                <strong>1</strong> Liked
              </span>
              <span>
                •
                <strong>4</strong> Comments
              </span>
              <a
                class="gitment-header-issue-link"
                href="https://github.com/DomBro96/DomBro96.github.io/issues/3"
                target="_blank"
              >Issue Page</a>
            </div>
          </div>
          <div>
            <div lang="en-US" class="gitment-container gitment-comments-container">
              <ul class="gitment-comments-list">
                <li class="gitment-comment">
                  <a
                    class="gitment-comment-avatar"
                    href="https://github.com/zhangzuxiong"
                    target="_blank"
                  >
                    <img class="gitment-comment-avatar-img" src="@/assets/avatar/commentAvatar.png" />
                  </a>
                  <div class="gitment-comment-main">
                    <div class="gitment-comment-header">
                      <a
                        class="gitment-comment-name"
                        href="https://github.com/zhangzuxiong"
                        target="_blank"
                      >zhangzuxiong</a>
                      commented on
                      <span
                        title="Tue Dec 05 2017 21:32:44 GMT+0800 (China Standard Time)"
                      >Tue Dec 05 2017</span>

                      <div class="gitment-comment-like-btn">
                        <svg
                          class="gitment-heart-icon"
                          xmlns="http://www.w3.org/2000/svg"
                          viewBox="0 0 50 50"
                        >
                          <path
                            d="M25 39.7l-.6-.5C11.5 28.7 8 25 8 19c0-5 4-9 9-9 4.1 0 6.4 2.3 8 4.1 1.6-1.8 3.9-4.1 8-4.1 5 0 9 4 9 9 0 6-3.5 9.7-16.4 20.2l-.6.5zM17 12c-3.9 0-7 3.1-7 7 0 5.1 3.2 8.5 15 18.1 11.8-9.6 15-13 15-18.1 0-3.9-3.1-7-7-7-3.5 0-5.4 2.1-6.9 3.8L25 17.1l-1.1-1.3C22.4 14.1 20.5 12 17 12z"
                          />
                        </svg>
                      </div>
                    </div>
                    <div class="gitment-comment-body gitment-markdown">
                      <p>非常不错的文章，强烈推荐！！！</p>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div>
            <div lang="en-US" class="gitment-container gitment-editor-container">
              <a
                class="gitment-editor-avatar"
                href="https://github.com/login/oauth/authorize?scope=public_repo&amp;redirect_uri=https%3A%2F%2Fdombro96.github.io%2F2017%2F12%2F04%2F%25E5%25A0%2586%25E6%258E%2592%25E5%25BA%258F-HeapSort%2F&amp;client_id=4a6fa6686f2dd417ed61&amp;client_secret=cc1f043ee266bc750c481d6a24a98188a185e2eb"
                title="login with GitHub"
              >
                <svg
                  class="gitment-github-icon"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 50 50"
                >
                  <path
                    d="M25 10c-8.3 0-15 6.7-15 15 0 6.6 4.3 12.2 10.3 14.2.8.1 1-.3 1-.7v-2.6c-4.2.9-5.1-2-5.1-2-.7-1.7-1.7-2.2-1.7-2.2-1.4-.9.1-.9.1-.9 1.5.1 2.3 1.5 2.3 1.5 1.3 2.3 3.5 1.6 4.4 1.2.1-1 .5-1.6 1-2-3.3-.4-6.8-1.7-6.8-7.4 0-1.6.6-3 1.5-4-.2-.4-.7-1.9.1-4 0 0 1.3-.4 4.1 1.5 1.2-.3 2.5-.5 3.8-.5 1.3 0 2.6.2 3.8.5 2.9-1.9 4.1-1.5 4.1-1.5.8 2.1.3 3.6.1 4 1 1 1.5 2.4 1.5 4 0 5.8-3.5 7-6.8 7.4.5.5 1 1.4 1 2.8v4.1c0 .4.3.9 1 .7 6-2 10.2-7.6 10.2-14.2C40 16.7 33.3 10 25 10z"
                  />
                </svg>
              </a>

              <div class="gitment-editor-main">
                <div class="gitment-editor-header">
                  <nav class="gitment-editor-tabs">
                    <button class="gitment-editor-tab gitment-selected">Write</button>
                    <button class="gitment-editor-tab">Preview</button>
                  </nav>
                </div>
                <div class="gitment-editor-body">
                  <div class="gitment-editor-write-field">
                    <textarea placeholder="Leave a comment" title="Login to Comment" disabled></textarea>
                  </div>
                </div>
              </div>
              <div class="gitment-editor-footer">
                <button class="gitment-editor-submit" title="Login to Comment" disabled>Comment</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </Card>
  </div>
</template>
<script>
export default {
  data() {
    return {
      isCollapsed: false
    };
  },
  computed: {},
  components: {}
};
</script>