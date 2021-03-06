import axios from "axios";

const API_URL = 'http://192.168.5.192:8080';

class AuthenticationService {

    isUserLoggedIn() {
        return (null !== sessionStorage.getItem("user"));
    }

    doBasicAuth(tenant, username, password) {
        return axios.post(`${API_URL}/login/basic`, {tenant, username, password},
            {headers: {authorization: this.createBasicAuthToken(tenant, username, password)}})
    }

    createBasicAuthToken(tenant, username, password) {
        return 'Basic ' + window.btoa(username + '|' + tenant + ':' + password);
    }

    registerLogin(tenant, username, password) {
        sessionStorage.setItem("user", username);
        sessionStorage.setItem("tenant", tenant);
        this.setupAxiosInterceptors(this.createBasicAuthToken(tenant, username, password))
    }

    logout() {
        sessionStorage.removeItem("user");
        sessionStorage.removeItem("tenant");
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