<template>
    <div class="login-container show">
        <router-link to="dashboard">/dashboard</router-link>

        <div @click="clear">测试</div>

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
}

</style>