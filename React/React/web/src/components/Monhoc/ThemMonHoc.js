import { Button, Container, Form } from "react-bootstrap";

const ThemMonHoc = () => {

    return (
        <Container>
            <h1 className="text-center text-info mt-1">QUẢN LÝ MÔN HỌC</h1>
            <Form>
                <Form.Group className="mb-3" controlId="tenmonhoc">
                    <Form.Label>Tên môn học</Form.Label>
                    <Form.Control type="text" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="mota">
                    <Form.Label>Mô tả môn học</Form.Label>
                    <Form.Control type="text" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="giangvienphutrach">
                    <Form.Label>Giảng viên phụ trách</Form.Label>
                    <Form.Select aria-label="Default select example">
                        <option></option>
                        <option value="1">Trương Văn C</option>
                        <option value="2">Nguyễn Văn A</option>
                        <option value="3">Trần Thị B</option>
                        <option value="3">Lê Văn D</option>
                    </Form.Select>
                </Form.Group>
                <Form.Group className="mb-3" controlId="danhmucmonhoc">
                    <Form.Label>Danh mục môn học</Form.Label>
                    <Form.Select aria-label="Default select example">
                        <option></option>
                        <option value="1">Ngoại ngữ</option>
                        <option value="2">Đại cương</option>
                        <option value="3">Chuyên ngành</option>
                        <option value="4">Chính trị</option>
                        <option value="5">Thể chất</option>
                    </Form.Select>
                </Form.Group>
                <Form.Group className="mb-3" controlId="avatar">
                    <Button type="submit" value="primary">Thêm môn học</Button>
                </Form.Group>
            </Form>

        </Container>
    );
}

export default ThemMonHoc;