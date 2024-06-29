import { Button, Container } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const Home = () => {

    const navigate = useNavigate();

    const handleRegisterClick = () => {
        navigate('/register/');
    };

    const handleLoginClick = () => {
        navigate('/login/');
    };

    return (

        
        <Container className="text-center mt-5">
            <h1 className="text-center text-primary">QUẢN LÝ ĐIỂM SINH VIÊN</h1>
            <Button variant="primary" className="me-4 mt-5" size="lg" type="submit" onClick={handleRegisterClick}>Đăng ký</Button>
            <Button variant="info" className="me-4 mt-5" size="lg" type="submit" onClick={handleLoginClick}>Đăng nhập</Button>
        </Container>
    );
}
export default Home;