<script setup>
import {
    Edit,
    Delete
} from '@element-plus/icons-vue'
import { onMounted, ref } from 'vue'

const categorys = ref([])


import { QicaiListService} from '@/api/qicai.js'



// 异步函数
const articleCategoryList = async () => {
    try {
        let result = await QicaiListService();           
        categorys.value = result.data;
        console.log(categorys.value)
    } catch (error) {
        console.error("获取分类数据失败:", error);
        // 可以在这里进行错误提示，比如更新 UI 提示用户
    }
}

// 调用异步函数


onMounted(()=>{
 articleCategoryList();
})


//控制添加分类弹窗
const dialogVisible = ref(false)

</script>
<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>器材查看</span>
                
            </div>
        </template>
        <el-table :data="categorys" style="width: 100%">
            
            <!-- <el-table-column label="图片" prop="qctp" width="100" > </el-table-column> -->
            <el-table-column label="器材名称" prop="qcname"></el-table-column>
            <el-table-column label="价格" prop="jiage"></el-table-column>
            <el-table-column label="购买时间" prop="goumaitime" ></el-table-column>
           
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






