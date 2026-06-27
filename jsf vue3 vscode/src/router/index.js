import {createRouter,createMemoryHistory, createWebHistory} from 'vue-router'
//导入组件
import LoginVue from '@/views/Login.vue'
import LayoutVue from '@/views/Layout.vue';

import AdminLayoutVue from '@/views/Admin/AdminLayout.vue'
import AdminHuiykVue from '@/views/Admin/AdminHuiyk.vue';
import AdminQicaiVue from '@/views/Admin/AdminQicai.vue';
import AdminUserAvatarVue from '@/views/Admin/AdminUser/AdminUserAvatar.vue';
import AdminUserInfoVue from '@/views/Admin/AdminUser/AdminUserInfo.vue';
import AdminUserResetPasswordVue from '@/views/Admin/AdminUser/AdminUserResetPassword.vue';
import AdminScoreVue from '@/views/Admin/AdminUser/AdminScore.vue';
import AdminZKaVue from '@/views/Admin/AdminUser/AdminZKa.vue';
import AdminTuanKeVue from '@/views/Admin/AdminUser/AdminTuanKe.vue';
import AdminJiaolianVue from '@/views/Admin/AdminUser/AdminJiaolian.vue';
import AdminPlVue from '@/views/Admin/AdminUser/AdminPl.vue';
import AdminUserVue from '@/views/Admin/AdminUser/AdminUser.vue';


import HuiyuankaVue from '@/views/article/Huiyuanka.vue';
import QicaichakanVue from '@/views/article/Qicaichakan.vue';
import UserAvatarVue from '@/views/user/UserAvatar.vue';
import UserInfoVue from '@/views/user/UserInfo.vue';
import UserTuankeVue from '@/views/user/Tuanke.vue'
import MyscoreVue from '@/views/user/Myscore.vue';
import JiaolianVue from '@/views/user/Jiaolian.vue';
import ScoreVue from '@/views/user/Score.vue';
import MyhykVue from '@/views/user/Myhyk.vue';
import PlVue from '@/views/user/Pl.vue';
import jiaolianxqVue from '@/views/user/jiaolianxq.vue';
import ShipuVue from '@/views/user/shipu.vue';


//定义路由关系
const routes=[
    { path:'/login',component:LoginVue },

    { path:'/Adminzhuye',component:AdminLayoutVue,redirect:'/admin/Qicai',children:[
        {path:'/admin/Huiyk',component:AdminHuiykVue},
        {path:'/admin/Jiaolian',component:AdminJiaolianVue},
        {path:'/admin/Qicai',component:AdminQicaiVue},
        {path:'/admin/User',component:AdminUserVue},
        {path:'/admin/Score',component:AdminScoreVue},
        {path:'/admin/ZhuanKa',component:AdminZKaVue},
        {path:'/admin/TuanKe',component:AdminTuanKeVue},
        {path:'/admin/Pl',component:AdminPlVue},
        {path:'/admin/info',component:AdminUserInfoVue},
        {path:'/admin/avatar',component:AdminUserAvatarVue}
     
    ]},
    { path:'/zhuye',component: LayoutVue,redirect:'/qicai/chakan',children:[
        {path:'/huiyuanka',component:HuiyuankaVue},
        {path:'/qicai/chakan',component:QicaichakanVue},
        {path:'/myscore',component:MyscoreVue},
        {path:'/jiaolian',component:JiaolianVue},
        {path:'/score',component:ScoreVue},
        {path:'/Pl',component:PlVue},
        {path:'/jiaolianxq',component:jiaolianxqVue},
        {path:'/myhyk',component:MyhykVue},
        {path:'/user/info',component:UserInfoVue},
        {path:'/user/avatar',component:UserAvatarVue},
        {path:'/shipu',component:ShipuVue},
        {path:'/tuanke',component:UserTuankeVue}
    ]}
]

//创建路由器
const router= createRouter({
    history:createWebHistory(),
    routes:routes
    

})

//导出路由
export default router