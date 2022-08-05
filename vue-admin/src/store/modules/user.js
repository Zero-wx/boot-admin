import { defineStore } from 'pinia'

import { login } from "@/api/user";
import { getToken, setToken } from "@/utils/auth";

const userPiniaStore = defineStore({
    id: 'userPinia',
    state: () => ({
        token: getToken() || '',
        roles: [],
        routes: [],
    }),
    actions: {
        // user login
        accountLogin(params) {
            return new Promise((resolve, reject) => {
                login(params).then(res => {
                    console.log(res, 'Pinia')
                    const {token} = res.data
                    setToken(token)
                    resolve(res)
                }).catch(err => {
                    reject(err)
                })
            })
        }
    },
    getters: {}
})

export default userPiniaStore;