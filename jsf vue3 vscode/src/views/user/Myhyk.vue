<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'

const hyks = ref([])

import { MyhykListService,MyhykDeleteService} from '@/api/myhyk';



// 异步函数
const AllHykList = async () => {
    try {
        let result = await  MyhykListService();           
        hyks .value = result.data;
        console.log(hyks .value)
    } catch (error) {
        console.error("获取分类数据失败:", error);
        // 可以在这里进行错误提示，比如更新 UI 提示用户
    }
}

// 调用异步函数


onMounted(()=>{
    AllHykList ();
})

const hykModel = ref({
    dengji: '',
    jiage: '',
    goumaitime:'',
    daoqitime:''
})



import {ElMessageBox,ElMessage} from 'element-plus'

const quxiao = (row) => {
     //提示用户  确认框
     hykModel.value.id = row.id
     ElMessageBox.confirm(
         '你确认要退卡吗?',
         '温馨提示',
        {
             confirmButtonText: '确认',
             cancelButtonText: '取消',
             type: 'warning',
         }
     )
         .then(async () => {
             //调用接口
             
             let result = await MyhykDeleteService(row.id);
             ElMessage({
                 type: 'success',
                 message: '退卡成功',
             })
             //刷新列表
             AllHykList();
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
                <span>我的会员卡</span>
                
            </div>
        </template>
        <el-table :data="hyks" style="width: 100%">
            
           
            <el-table-column label="等级" prop="dengji"></el-table-column>
            <el-table-column label="价格" prop="jiage"></el-table-column>
            <el-table-column label="购买时间" prop="goumaitime" ></el-table-column>
            <el-table-column label="到期时间" prop="daoqitime" ></el-table-column>
            <el-table-column label="操作" width="100">
        <template #default="{ row }">
          <el-button size="mini" @click="quxiao(row)" >退卡</el-button>
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






