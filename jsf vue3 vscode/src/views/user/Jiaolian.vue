<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'

const jiaolians = ref([])


import { JiaolianListService } from '@/api/jiaolian';



// 异步函数
const AllJiaolianList = async () => {
    try {
        let result = await  JiaolianListService();           
        jiaolians.value = result.data;
        console.log(jiaolians.value)
    } catch (error) {
        console.error("获取分类数据失败:", error);
        // 可以在这里进行错误提示，比如更新 UI 提示用户
    }
}

// 调用异步函数


onMounted(()=>{
    AllJiaolianList();
})


//控制添加分类弹窗
const dialogVisible = ref(false)

</script>
<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>教练查看</span>
                
            </div>
        </template>
        <el-table :data="jiaolians " style="width: 100%">
            
          
            <el-table-column label="教练姓名" prop="name"></el-table-column>
            <el-table-column label="年龄" prop="old"></el-table-column>
            <el-table-column label="性别" prop="xinbie" ></el-table-column>
            <el-table-column label="擅长课程" prop="sckc" ></el-table-column>
           
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






