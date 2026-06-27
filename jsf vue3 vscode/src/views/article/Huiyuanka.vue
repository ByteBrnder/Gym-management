<script setup>

import { ElTable, ElTableColumn, ElButton } from 'element-plus'

import { onMounted, ref } from "vue";
// 用于存储已经购买过的会员卡id的数组
const reservedIds = ref([]);
const huiyuankas = ref([]);

import { HuiyuankaListService } from "@/api/huiyuanka";

// 异步函数
const AllHuiyuankaList = async () => {
  try {
    let result = await HuiyuankaListService();
    huiyuankas.value = result.data;
    console.log(huiyuankas.value);
  } catch (error) {
    console.error("获取分类数据失败:", error);
    // 可以在这里进行错误提示，比如更新 UI 提示用户
  }
};

// 调用异步函数

onMounted(() => {
  AllHuiyuankaList ();
});


import { HykGoumaiService } from '@/api/huiyuanka';
import { MyhykupdateService } from '@/api/myhyk';
import {ElMessageBox,ElMessage} from 'element-plus'
import { userInfoService } from '@/api/user';


const huiyuankaModel = ref({
    dengji: '',
    jiage: '',
    
  
    
})


const goumai = async(row) => {

         // 先判断当前会员卡是否已经购买过
         if (reservedIds.value.includes(row.id)) {
        ElMessage({
            type: 'warning',
            message: '该会员卡已购买，请勿重复购买',
        });
        return;
    }
     //提示用户  确认框
     huiyuankaModel.value.id = row.id
     ElMessageBox.confirm(
         '你确认要购买该会员卡吗?',
         '温馨提示',
        {
             confirmButtonText: '确认',
             cancelButtonText: '取消',
             type: 'warning',
         }
     )
         .then(async () => {
             //调用接口
             
             let result = await HykGoumaiService(row.id);
             let result2= await MyhykupdateService(new Date())
          
             ElMessage({
                 type: 'success',
                 message: '购买成功',
             })
               // 将购买成功的会员卡id添加到已购买列表中
               reservedIds.value.push(row.id);
             //刷新列表
             AllHuiyuankaList();
         })
         .catch(() => {
             ElMessage({
                 type: 'info',
                 message: '用户取消了购买',
             })
         })
 }



//控制添加分类弹窗
const dialogVisible = ref(false);
</script>
<template>
  <el-card class="page-container">
    <template #header>
      <div class="header">
        <span>会员卡查看</span>
      </div>
    </template>
    <el-table :data="huiyuankas" style="width: 100%">
      <el-table-column label="等级" prop="dengji"></el-table-column>
      <el-table-column label="价格" prop="jiage"></el-table-column>
      <el-table-column label="操作" width="100">
        <template #default="{ row }">
          <el-button size="mini" @click="goumai(row)">购买</el-button>
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
