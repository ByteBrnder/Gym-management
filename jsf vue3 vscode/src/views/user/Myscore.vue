<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'

const scores = ref([])

import { MyScoreListService,MyScoreDeleteService } from '@/api/myscore';



// 异步函数
const AllScoreList = async () => {
    try {
        let result = await  MyScoreListService();           
        scores .value = result.data;
        console.log(scores .value)
    } catch (error) {
        console.error("获取分类数据失败:", error);
        // 可以在这里进行错误提示，比如更新 UI 提示用户
    }
}

// 调用异步函数


onMounted(()=>{
    AllScoreList ();
})

const scoreModel = ref({
    kcname: '',
    jiaolian: '',
    kctime:'',
    sxhykdj:''
})



import {ElMessageBox,ElMessage} from 'element-plus'

const quxiao = (row) => {
     //提示用户  确认框
     scoreModel.value.id = row.id
     ElMessageBox.confirm(
         '你确认要取消预约该课程吗?',
         '温馨提示',
        {
             confirmButtonText: '确认',
             cancelButtonText: '取消',
             type: 'warning',
         }
     )
         .then(async () => {
             //调用接口
             
             let result = await MyScoreDeleteService(row.id);
             ElMessage({
                 type: 'success',
                 message: '取消成功',
             })
             //刷新列表
             AllScoreList();
         })
         .catch(() => {
             ElMessage({
                 type: 'info',
                 message: '用户取消',
             })
         })
 }


//控制添加分类弹窗
const dialogVisible = ref(false)

</script>
<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>我的课程</span>
                
            </div>
        </template>
        <el-table :data="scores" style="width: 100%">
            
           
            <el-table-column label="课程名称" prop="kcname"></el-table-column>
            <el-table-column label="教练" prop="jiaolian"></el-table-column>
            <el-table-column label="课程时间" prop="kctime" ></el-table-column>
            <el-table-column label="所需会员卡等级" prop="sxhykdj" ></el-table-column>
            <el-table-column label="操作" width="100">
        <template #default="{ row }">
          <el-button size="mini" @click="quxiao(row)" >取消</el-button>
       </template>
      </el-table-column>
            <template #empty>
                <el-empty description="没有数据" />
            </template>
        </el-table>

        
    </el-card>
</template>

<style lang="scss" scoped>
.page-container {
    min-height: 100%;
    box-sizing: border-box;

    .header {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
}
</style>






