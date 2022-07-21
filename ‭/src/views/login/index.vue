<template>
    <div class="login-container">
        <div class="content">
            <div class="title">
                <p>xxx测试管理后台</p>
            </div>
        </div>
    </div>
</template>

<script setup>
import swal from "sweetalert";

function clear() {
    console.log("asd");
    swal("", "Hello world!", "success", { buttons: false, timer: 2000 });
}


</script>

<style scoped>
.login-container {
    height: 100%;
    background-color: #7e8c8d;
    border: 1px solid red;
}

</style>