import React from 'react';
import { Table } from 'react-bootstrap';

function Xemmondahoc() {
    return (
        <div className="container mt-4">
            <h1 className="mb-4">Danh sách môn đã học</h1>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Mã môn học</th>
                        <th>Tên môn học</th>
                        <th>Giảng viên phụ trách</th>
                        <th>Giữa kỳ</th>
                        <th>Cuối kỳ</th>
                        <th>Cột điểm thêm</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>5</td>
                        <td>
                            <a href="#!">Tiếng Anh Cơ Bản</a>
                        </td>
                        <td>Nguyễn Văn A</td>
                        <td>8.0</td>
                        <td>7.5</td>
                        <td>8.5</td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td>
                            <a href="#!">Triết Học Mác-Lênin</a>
                        </td>
                        <td>Trương Văn C</td>
                        <td>7.0</td>
                        <td>8.0</td>
                        <td>7.5</td>
                    </tr>
                </tbody>
            </Table>
        </div>
    );
}

export default Xemmondahoc;
