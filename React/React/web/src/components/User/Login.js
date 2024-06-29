import { useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import APIs, { authApi, endpoints } from "../../configs/APIs";
import cookies from 'react-cookies';
import { useNavigate } from "react-router-dom";

const Login = () => {
    const fields = [{
        label: "Tên đăng nhập",
        type: "text",
        field: "username",
    }, {
        label: "Mật khẩu",
        type: "password",
        field: "password",
    }];

    const [user, setUser] = useState({});
    const navigate = useNavigate();
    const change = (e, field) => {
        setUser(current => {
            return { ...current, [field]: e.target.value }
        })
    }

    const handleClick = () => {
        navigate('/danhsachmonhoc/');
    };


    const login = async (e) => {
        e.preventDefault();
        try{
            let res = await APIs.post(endpoints['login'], {...user});
            console.info(res.data);
            cookies.save('token', res.data);

            let user = await authApi().get(endpoints['current-user']);
            console.info(user.data);
        } catch (ex){
            console.error(ex);
        }
    }


    return (
        <Container>
            <h1 className="text-center text-info mt-1">ĐĂNG NHẬP</h1>
            <Form onSubmit={login}>
                {fields.map(f => <Form.Group key={f.field} className="mb-3" controlId={f.field}>
                    <Form.Label>{f.label}</Form.Label>
                    <Form.Control onChange={e => change(e, f.field)} value={user[f.field]} type={f.type} placeholder={f.label} />
                </Form.Group>)}
                <Form.Group className="mb-3" controlId="avatar">
                    <Button type="submit" value="primary" onClick={handleClick}>Đăng nhập</Button>
                </Form.Group>
            </Form>

        </Container>
    );
}

export default Login;