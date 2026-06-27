import request from '@/utils/request.js'
//课程查看
export const MyScoreListService=()=>{

    return request.get('/myscore/chakan')
   }


   //课程删除
export const MyScoreDeleteService=(id)=>{
    return request.delete('/myscore/delete?id='+id)
 }

