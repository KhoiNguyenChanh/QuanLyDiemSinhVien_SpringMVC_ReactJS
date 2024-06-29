import { BrowserRouter, Route, Routes, useLocation } from "react-router-dom";
import Header from "./components/Commons/Header";
import Footer from "./components/Commons/Footer";
import 'bootstrap/dist/css/bootstrap.min.css';
import Register from "./components/User/Register";
import Home from "./components/Monhoc/Home";
import Login from "./components/User/Login";
import ThemMonHoc from "./components/Monhoc/ThemMonHoc";
import { Container } from "react-bootstrap";
import ThemNguoiDung from "./components/Monhoc/ThemNguoiDung";
import DanhSachMonHoc from "./components/Monhoc/DanhSachMonHoc";
import Chat from "./components/Chat/Chat";
import Xemdiem from "./components/GiangVien/Xemdiem";
import Forum from "./components/Forum/Forum";
import Xemmondahoc from "./components/SinhVien/Xemmondahoc";


const Layout = ({ children }) => {
  const location = useLocation();
  const noHeaderRoutes = ['/login/', '/register/', '/xemmondahoc/', '/chat/', '/'];

  return (
    <>
      {!noHeaderRoutes.includes(location.pathname) && <Header />}
      {children}
    </>
  );
};

const App = () => {
  //const [user, dispatch] = useReducer(MyUserReducer, null);
  return (
    <BrowserRouter>
      <Layout>
        <Container>
          <Routes>
            {/* Trang chủ */}
            <Route path='/' element={<Home />}></Route>
            {/* Trang đăng ký */}
            <Route path='/register' element={<Register />}></Route>
            {/* Trang đăng nhập */}
            <Route path='/login' element={<Login />}></Route>
            {/* Trang thêm môn học của admin*/}
            <Route path='/themmonhoc' element={<ThemMonHoc />}></Route>
            {/* Trang thêm người dùng của admin */}
            <Route path='/themnguoidung' element={<ThemNguoiDung />}></Route>
            {/* Trang các môn học */}
            <Route path='/danhsachmonhoc' element={<DanhSachMonHoc />}></Route>
            {/* Trang chat giữa giảng viên và sinh viên */}
            <Route path='/chat' element={<Chat />}></Route>
            {/* Trang giảng viên xem danh sách sinh viên trong 1 lớp và điểm*/}
            <Route path='/xemdiem' element={<Xemdiem />}></Route>
            {/* Trang forum trong 1 lớp học*/}
            <Route path='/forum' element={<Forum />}></Route>
            {/* Trang của sinh viên xem môn đã học và điểm */}
            <Route path='/xemmondahoc' element={<Xemmondahoc />}></Route>
          </Routes>
        </Container>
      </Layout>
      <Footer />
    </BrowserRouter>
  );
}
export default App;