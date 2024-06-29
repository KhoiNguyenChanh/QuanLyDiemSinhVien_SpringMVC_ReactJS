import { useEffect, useState } from "react";
import { Button, Table } from "react-bootstrap";
import APIs, { endpoints } from "../../configs/APIs";
import MySpinner from "../Commons/MySpinner";
import { useNavigate, useSearchParams } from "react-router-dom";
import styled from 'styled-components';

const StyledTable = styled(Table)`
  width: 100%;
  margin: 20px 20px;

  th, td {
    padding: 12px 15px;
    border: 1px solid #ddd;
  }

  th {
    background-color: #f4f4f4;
    text-align: center;
  }

  tbody tr:nth-child(even) {
    background-color: #f9f9f9;
  }

  tbody tr:hover {
    background-color: #f1f1f1;
  }

  td:nth-child(1),
  td:nth-child(2) {
    text-align: center;
  }

  td:nth-child(3),
  td:nth-child(4) {
    text-align: center;
  }
`;

const DanhSachMonHoc = () => {
    const [monhocs, setMonhocs] = useState([]);
    const [loading, setLoading] = useState(false); // Hiển thị spinner
    const [q] = useSearchParams();
    const navigate = useNavigate();

    const loadMonhocs = async () => {
        setLoading(true);
        try {
            let url = endpoints['monhocs'];
            let monhocId = q.get('monhocId');
            if (monhocId)
                url = `${url}?monhocId=${monhocId}`;

            let res = await APIs.get(url);
            setMonhocs(res.data);
        } catch (ex) {
            console.error(ex);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        loadMonhocs();
    }, [q]);

    const handleThemMonHocClick = () => {
        navigate('/themmonhoc/');
    };

    const handleThemNguoiDungClick = () => {
        navigate('/themnguoidung/');
    };
    return (
        <>
            {loading && <MySpinner />}
            <h1 className="text-center text-info mt-1">DANH SÁCH MÔN HỌC</h1>
            <Button type="submit" value="primary" onClick={handleThemMonHocClick} >Thêm môn học</Button>{' '}
            <Button type="submit" value="primary" onClick={handleThemNguoiDungClick} variant="success">Thêm người dùng</Button>
            {monhocs.map(p => (
                <StyledTable key={p.id} striped bordered hover className='p-3'>
                    <thead>
                        <tr>
                            <th>Tên môn học</th>
                            <th>Mô tả</th>
                            <th>Giảng viên phụ trách</th>
                            <th>Chi tiết môn học</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>{p.ten}</td>
                            <td>{p.moTaMonHoc}</td>
                            <td>{p.tenGiangVien}</td>
                            <td>
                                <Button>Xem chi tiết</Button>{' '}
                                <Button variant="success">Cập nhật môn</Button>{' '}
                                <Button variant="danger">Xóa môn</Button>
                            </td>
                        </tr>
                    </tbody>
                </StyledTable>
            ))}
        </>
    );
};

export default DanhSachMonHoc;
