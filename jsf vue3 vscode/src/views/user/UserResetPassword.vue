

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { ElMessage } from 'element-plus';
import { validate } from 'vee-validate';
import { userResetPasswordService } from '@/api/user';
import { useTokenStore } from '@/stores/token';
const tokenStore=useTokenStore();
import useUserInfoStore from '@/stores/userInfo.js'
const userInfoStore = useUserInfoStore();

const router = useRouter();
const passwordForm = ref({
    oldPassword: '',
    newPassword: '',
    confirmNewPassword: '',
});

// 定义表单验证规则
const rules = {
    oldPassword: [
        { required: true, message: '请输入旧密码', trigger: 'blur' },
    ],
    newPassword: [
        { required: true, message: '请输入新密码', trigger: 'blur' },
    ],
    confirmNewPassword: [
        { required: true, message: '请确认新密码', trigger: 'blur' },
    ],
};

// 重置密码的函数
const resetPassword = async () => {
    //先进行表单验证
    // const valid = await passwordForm.value.validate();
    // if (!valid) {
    //     return;
    // }

    // 调用接口重置密码
    let result = await userResetPasswordService(passwordForm.value);
    console.log(passwordForm.value.oldPassword);
    console.log(passwordForm.value.newPassword);
    console.log(passwordForm.value.confirmNewPassword);
    
    if (result.success) {
        ElMessage.success(result.msg? result.msg : '密码重置成功');
        // 可能需要额外的逻辑，比如让用户重新登录等
        // 退出登录
        // 1. 清空pinia中存储的token以及个人信息
        tokenStore.removeToken();
        userInfoStore.removeInfo();

        // 2. 跳转到登录页面
        router.push('/login');
        ElMessage({
            type: 'success',
            message: '请重新登录',
            });
    } else {
        let errorMessage = '密码重置失败';
        if (result.errorCode === 'INVALID_OLD_PASSWORD') {
            errorMessage = '旧密码错误，请重新输入';
        } else if (result.errorCode === 'PASSWORD_TOO_SHORT') {
            errorMessage = '新密码长度不符合要求，请重新输入';
        } else if (result.errorCode === 'CONFIRM_PASSWORD_MISMATCH') {
            errorMessage = '确认新密码与新密码不一致，请重新输入';
        } else {
            errorMessage = result.msg? result.msg : '密码重置失败，请重试';
        }
        ElMessage.error(errorMessage);
    }
};
</script>
<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>重置密码</span>
            </div>
        </template>
        <el-row>
            <el-col :span="12">
                <el-form
                    :model="passwordForm"
                    :rules="rules"
                    label-width="100px"
                    size="large"
                >
                    <el-form-item label="旧密码" prop="oldPassword">
                        <el-input
                            v-model="passwordForm.oldPassword"
                            type="password"
                            placeholder="请输入旧密码"
                        ></el-input>
                    </el-form-item>
                    <el-form-item label="新密码" prop="newPassword">
                        <el-input
                            v-model="passwordForm.newPassword"
                            type="password"
                            placeholder="请输入新密码"
                        ></el-input>
                    </el-form-item>
                    <el-form-item label="确认新密码" prop="confirmNewPassword">
                        <el-input
                            v-model="passwordForm.confirmNewPassword"
                            type="password"
                            placeholder="请再次输入新密码"
                        ></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="resetPassword">提交修改</el-button>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </el-card>
</template>
<style lang="scss" scoped>
.page-container {
    margin: 20px;
}
</style>