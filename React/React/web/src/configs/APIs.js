import axios from "axios";
import cookies from 'react-cookies';

const BASE_URL = 'http://localhost:8080/QuanLyDiemSinhVien/';

export const endpoints = {
    'monhocs': '/api/monhocs/', //API đổ ra các môn học
    'register': '/register/', 
    'login': '/login/',
    'danhmuc': '/api/danhmuc/', //API đổ ra các danh mục
    'users':'/api/users/'
}

export const authApi = () => {
    return axios.create({
        baseURL: BASE_URL,
        headers: {
            'Authorization': `${cookies.load('token')}`
        }
    });
}

export default axios.create({
    baseURL: BASE_URL
});