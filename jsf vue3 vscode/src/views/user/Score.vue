<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'
// 用于存储已经预约过的课程id的数组
const reservedIds = ref([]);
const scores = ref([])

import { ScoreListService,ScoreYuyueService } from '@/api/score';
import {ElMessageBox,ElMessage} from 'element-plus'
import { userInfoService } from '@/api/user';


const scoreModel = ref({
    kcname: '',
    jiaolian: '',
    kctime:'',
    sxhykdj:''
})


const yuyue = async (row) => {
        // 先判断当前课程是否已经预约过
        if (reservedIds.value.includes(row.id)) {
        ElMessage({
            type: 'warning',
            message: '该课程已预约，请勿重复预约',
        });
        return;
    }

     //提示用户  确认框
     scoreModel.value.id = row.id;
     ElMessageBox.confirm(
         '你确认要预约该课程吗?',
         '温馨提示',
        {
             confirmButtonText: '确认',
             cancelButtonText: '取消',
             type: 'warning',
         }
     )
        .then(async () => {
             //调用接口
             
             let result = await ScoreYuyueService(row.id);
             ElMessage({
                 type: 'success',
                 message: '预约成功',
             })
                 // 将预约成功的课程id添加到已预约列表中
                 reservedIds.value.push(row.id);
             //刷新列表
             AllScoreList();
         })
         
         .catch(() => {
             ElMessage({
                 type: 'info',
                 message: '用户取消了预约',
             })
         })
 }





// 异步函数
const AllScoreList = async () => {
    try {
        let result = await  ScoreListService();           
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


//控制添加分类弹窗
const dialogVisible = ref(false)

</script>
<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>课程查看预约</span>
                
            </div>
        </template>
        <el-table :data="scores" style="width: 100%">
            
           
            <el-table-column label="课程名称" prop="kcname"></el-table-column>
            <el-table-column label="教练" prop="jiaolian"></el-table-column>
            <el-table-column label="课程时间" prop="kctime" ></el-table-column>
            <el-table-column label="所需会员卡等级" prop="sxhykdj" ></el-table-column>
            <el-table-column label="操作" width="100">
        <template #default="{ row }">
          <el-button size="mini" @click="yuyue(row)" >预约</el-button>
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






