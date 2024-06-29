import React from 'react';
import { Button, Form, Table } from 'react-bootstrap';

function Forum() {
    return (
        <div className="container mt-4">
            <div className="d-flex mb-3 p-3">
                <Form.Control type="text" placeholder="Tìm kiếm diễn đàn" className="mr-2" />
                <Button variant="primary" className="mr-2 p-3">Tìm</Button>{' '}
            </div>
            <Button variant="success" >Thêm diễn đàn</Button>
            <br></br> <br></br>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Thảo luận</th>
                        <th>Người khởi tạo</th>
                        <th>Ngày khởi tạo</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <a href="#!">Chủ đề thảo luận 1</a>
                        </td>
                        <td>Người khởi tạo 1</td>
                        <td>2023-06-28</td>
                    </tr>
                    <tr>
                        <td>
                            <a href="#!">Chủ đề thảo luận 2</a>
                        </td>
                        <td>Người khởi tạo 2</td>
                        <td>2023-06-27</td>
                    </tr>
                </tbody>
            </Table>
        </div>
    );
}

export default Forum;
