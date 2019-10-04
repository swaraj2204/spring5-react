import axios from "axios";

const API_URL = 'http://localhost:8080';

class AuthenticationService {

    isUserLoggedIn() {
        let user = sessionStorage.getItem('user');
        if (user === null) return false;
        return true
    }

    doBasicAuth(tenant, username, password) {
        return axios.post(`${API_URL}/login/basic`, {tenant, username, password},
            {headers: {authorization: this.createBasicAuthToken(tenant, username, password)}})
    }

    createBasicAuthToken(tenant, username, password) {
        return 'Basic ' + window.btoa(username + '|' + tenant + ":" + password)
    }

    registerLogin(tenant, username, password) {
        sessionStorage.setItem('user', username);
        sessionStorage.setItem('tenant', tenant);
        this.setupAxiosInterceptors(this.createBasicAuthToken(tenant, username, password))
    }

    logout() {
        sessionStorage.removeItem('user');
        sessionStorage.removeItem('tenant')
    }

    setupAxiosInterceptors(token) {
        axios.interceptors.request.use(
            (config) => {
                if (this.isUserLoggedIn()) {
                    config.headers.authorization = token
                }
                return config
            }
        )
    }
}

export default new AuthenticationService()