import request from '@/utils/request.js'
//课程查看
export const ScoreListService=()=>{

    return request.get('/score/chakan')
   }

//课程添加
export const ScoreAddService=(scoreData)=>{
    return request.post('/score/tianjia',scoreData)
}

//课程修改
export const ScoreupdateService=(scoreData)=>{
    return request.put('/score/update',scoreData)
}

//课程删除
export const ScoreDeleteService=(id)=>{
   return request.delete('/score/delete?id='+id)
}

//课程预约
export const ScoreYuyueService=(id)=>{
    
    request.post('/score/yuyue?id='+id)
}