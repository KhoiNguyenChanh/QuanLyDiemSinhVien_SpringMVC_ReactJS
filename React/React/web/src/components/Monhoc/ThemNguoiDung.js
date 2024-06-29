import { Button, Container, Form } from "react-bootstrap";

const ThemNguoiDung = () => {
    return (
        <Container>
            <h1 className="text-center text-info mt-1">QUẢN LÝ NGƯỜI DÙNG</h1>
            <Form>
                <Form.Group className="mb-3" controlId="tennguoidung">
                    <Form.Label>Tên người dùng</Form.Label>
                    <Form.Control type="text" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="email">
                    <Form.Label>Email</Form.Label>
                    <Form.Control type="email" placeholder="tennguoidung@ou.vn" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="sodienthoai">
                    <Form.Label>Số điện thoại</Form.Label>
                    <Form.Control type="text" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="usename">
                    <Form.Label>Tên tài khoản</Form.Label>
                    <Form.Control type="text" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="password">
                    <Form.Label>Mật khẩu</Form.Label>
                    <Form.Control type="password" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="vaitro">
                    <Form.Label>Vai trò</Form.Label>
                    <Form.Select aria-label="Default select example">
                        <option></option>
                        <option value="1">Giảng viên</option>
                        <option value="2">Sinh viên</option>
                    </Form.Select>
                </Form.Group>
                <Form.Group className="mb-3" controlId="avatar">
                    <Form.Label>Ảnh đại diện (.png/.jpg)</Form.Label>
                    <Form.Control type="file" accept=".png, .jpg" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="avatar">
                    <Button type="submit" value="primary">Thêm người dùng</Button>
                </Form.Group>
            </Form>

        </Container>
    );
}

export default ThemNguoiDung;