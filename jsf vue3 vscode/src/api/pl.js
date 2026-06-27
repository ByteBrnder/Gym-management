import request from '@/utils/request.js'


//文章分类列表查询
export const PlListService=()=>{

 return request.get('/pl/chakan')
}

//器材添加
export const PlAddService=(plData)=>{
    return request.post('/pl/tianjia',plData)
}