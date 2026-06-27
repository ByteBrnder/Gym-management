<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'
// 用于存储已经预约过的课程id的数组
const reservedIds = ref([]);
const tuankes = ref([])


import { TuanKeListService } from '@/api/tuanke';
import { TuankeYuyueService } from '@/api/tuanke';
import {ElMessageBox,ElMessage} from 'element-plus'

const tuankeModel = ref({
    tkname: '',
    jiaolian: '',
    kctime:'',
    
})


const yuyue = async(row) => {

    const messageShown = ref(false);  // 新增标志位变量
         // 先判断当前课程是否已经预约过
         if (reservedIds.value.includes(row.id)) {
        ElMessage({
            type: 'warning',
            message: '该课程已预约，请勿重复预约',
        });
        return;
    }
    tuankeModel.value.id = row.id;
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
        // 调用接口
        let result = await TuankeYuyueService(row.id);
        
        if (result) {
            ElMessage({
                type: 'success',
                message: '预约成功',
                  
            })
               // 将预约成功的课程id添加到已预约列表中
               reservedIds.value.push(row.id);
            messageShown.value = true;  // 设置标志位为true
            // 刷新列表
            AllTuankeList();
        } else {
            ElMessage({
                type: 'error',
                message: '预约失败，请稍后重试',
            })
        }
    })
   .catch(() => {
        if (!messageShown.value) {  // 判断标志位，只有未显示过预约成功提示时才显示取消提示
            ElMessage({
                type: 'info',
                message: '用户取消了预约',
            })
        }
    })
}

// 异步函数
const AllTuanKeList = async () => {
    try {
        let result = await  TuanKeListService();           
        tuankes .value = result.data;
        console.log(tuankes .value)
    } catch (error) {
        console.error("获取分类数据失败:", error);
        // 可以在这里进行错误提示，比如更新 UI 提示用户
    }
}

// 调用异步函数


onMounted(()=>{
  AllTuanKeList ();
})







//控制添加分类弹窗
const dialogVisible = ref(false)

</script>
<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>团课查看预约</span>
                
            </div>
        </template>
        <el-table :data="tuankes " style="width: 100%">
            
            <!-- <el-table-column label="图片" prop="qctp" width="100" > </el-table-column> -->
            <el-table-column label="团课名称" prop="tkname"></el-table-column>
            <el-table-column label="教练" prop="jiaolian"></el-table-column>
            <el-table-column label="课程时间" prop="kctime" ></el-table-column>
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






