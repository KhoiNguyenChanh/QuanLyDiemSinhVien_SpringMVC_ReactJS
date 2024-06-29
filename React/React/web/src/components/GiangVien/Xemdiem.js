import React from 'react';
import { Form, Button, Table, Container, Row, Col } from 'react-bootstrap';


const Xemdiem = () => {
    return (
        <Container>
            <Row className="mb-3 p-3">
                <Col xs={12} md={8} className="d-flex align-items-center">
                    <Form className="w-100">
                        <Form.Group as={Row} className="mb-3" controlId="formSearch">
                            <Col xs={9}>
                                <Form.Control type="text" placeholder="Tìm kiếm sinh viên theo MSSV, họ tên" />
                            </Col>
                            <Col xs={3}>
                                <Button variant="primary" type="submit">Tìm</Button>
                            </Col>
                        </Form.Group>
                    </Form>
                </Col>
            </Row>
            <Row>
                <Col>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>MSSV</th>
                                <th>Tên</th>
                                <th>Lớp</th>
                                <th>Giữa kỳ</th>
                                <th>Cuối kì</th>
                                <th>Điểm cộng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>Nguyễn Văn A</td>
                                <td>DH21CS01</td>
                                <td>4</td>
                                <td>2</td>
                                <td>2</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Trần Thị B</td>
                                <td>DH21CS01</td>
                                <td>9</td>
                                <td>6</td>
                                <td>4</td>
                            </tr>
                            {/* Thêm các hàng dữ liệu khác ở đây */}
                        </tbody>
                    </Table>
                </Col>
            </Row>
            <Button variant="secondary">Lưu điểm</Button>{' '}
            <Button variant="success">Thêm cột điểm</Button>{' '}
            <Button variant="danger">Xóa cột điểm</Button>{' '}
            <Button variant="info">Xuất PDF</Button>{' '}
            <br></br> <br></br>
            <Button variant="warning">Forum</Button>{' '}
        </Container>
    );
}

export default Xemdiem;
