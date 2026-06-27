import { defineStore } from "pinia";
import { ref } from "vue";
import { userResetPasswordService } from "@/api/user";

const useUserInfoStore = defineStore('userInfo', () => {
    // 定义状态相关的内容
    const info = ref({});

    const setInfo = (newInfo) => {
        info.value = newInfo;
    };

    const removeInfo = () => {
        info.value = {};
    };

    // 新增：修改密码函数
    const updatePassword = async (oldPassword, newPassword,confirmNewPassword) => {
        try {
            // 调用接口更新密码，这里假设接口需要传入当前用户信息（从info中获取）、旧密码和新密码
            let result = await userResetPasswordService({
                user: info.value,
                oldPassword: oldPassword,
                newPassword: newPassword,
                confirmNewPassword:confirmNewPassword
            });

            if (result && result.success) { // 假设接口返回结果中有success字段表示是否成功
                ElMessage.success(result.msg? result.msg : '密码修改成功');
            } else {
                ElMessage.error(result.msg? result.msg : '密码修改失败，请重试');
            }
        } catch (error) {
            ElMessage.error('密码修改过程中出现错误，请检查网络或稍后重试');
        }
    };

    return { info, setInfo, removeInfo, updatePassword };
}, { persist: true });

export default useUserInfoStore;