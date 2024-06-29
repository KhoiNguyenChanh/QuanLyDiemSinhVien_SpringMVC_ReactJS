import { useEffect, useState } from "react";
import APIs, { endpoints } from "../../configs/APIs";
import { Button, Col, Container, Form, Image, Nav, NavDropdown, Navbar, Row, Spinner, } from "react-bootstrap";
import { Link } from "react-router-dom";


const Header = () => {
    const [danhmuc, setDanhmuc] = useState(null);

    const loadDanhmuc = async () => {
        try {
            let res = await APIs.get(endpoints['danhmuc']);
            setDanhmuc(res.data);
        } catch (ex) {
            console.error(ex);
        }
    }

    useEffect(() => {
        loadDanhmuc();
    }, [])



    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary" data-bs-theme="dark">
                <Container className="ms-0 text-start">
                    <Navbar.Brand>Quản lý điểm sinh viên</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="/" active>Trang chủ</Nav.Link>
                            <NavDropdown title="Danh mục" id="basic-nav-dropdown" active>
                                {danhmuc === null ? <Spinner animation="grow" variant="primary" /> : <>
                                    {danhmuc.map(c => {
                                        let url = `/?monhocId=${c.id}`;
                                        return <Link to={url} className="nav-link" key={c.id}>{c.tenDanhMuc}</Link>
                                    })}
                                </>}
                            </NavDropdown>
                            <Nav.Link href="/danhsachmonhoc" active>Các môn học</Nav.Link>
                            <NavDropdown title="Xem điểm" id="basic-nav-dropdown" active>
                                <NavDropdown.Item href="/xemdiem">Lớp DH21CS01</NavDropdown.Item>
                                <NavDropdown.Item href="/xemdiem">Lớp 2</NavDropdown.Item>
                                <NavDropdown.Item href="/xemdiem">Lớp 3</NavDropdown.Item>
                            </NavDropdown>
                            <Nav.Link href="/thongke" active>Thống kê</Nav.Link>
                        </Nav>
                        <Col xs={9} md={3}>
                            <Image src="holder.js/171x180" roundedCircle />
                        </Col>
                        <Button variant="link" href="/">Đăng xuất</Button>
                    </Navbar.Collapse>
                    {/* tim kiem */}
                    <Form inline>
                        <Row>
                            <Col xs="auto">
                                <Form.Control
                                    type="text"
                                    placeholder="Nhập môn học"
                                    className=" mr-sm-2"
                                />
                            </Col>
                            <Col xs="auto">
                                <Button type="submit">Tìm</Button>
                            </Col>
                        </Row>
                    </Form>
                </Container>
            </Navbar>
        </>
    );
}
export default Header;