<template>
  <router-view></router-view>
</template>
<script setup>

window.loader.show()


setTimeout(()=>{
  window.loader.hide()
},1500)


</script>
<style lang="scss">

</style>
