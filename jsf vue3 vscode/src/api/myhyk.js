import request from '@/utils/request.js'
//我的会员卡查看
export const MyhykListService=()=>{

    return request.get('/myhyk/chakan')
   }
//到期时间修改
   export const MyhykupdateService=(time)=>{
    console.log(time);
    
    return request.put('/myhyk/update',time)
}


   //会员卡退卡
   export const MyhykDeleteService=(id)=>{
    return request.delete('/myhyk/delete?id='+id)
 }