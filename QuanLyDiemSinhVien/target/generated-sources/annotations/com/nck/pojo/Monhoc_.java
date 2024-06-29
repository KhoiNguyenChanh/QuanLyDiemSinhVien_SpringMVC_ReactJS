package com.nck.pojo;

import com.nck.pojo.DanhMucMonHoc;
import com.nck.pojo.Lophoc;
import com.nck.pojo.Nguoidung;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-06-27T23:42:57")
@StaticMetamodel(Monhoc.class)
public class Monhoc_ { 

    public static volatile SingularAttribute<Monhoc, DanhMucMonHoc> danhMucMonHoc;
    public static volatile SingularAttribute<Monhoc, String> tenGiangVien;
    public static volatile SingularAttribute<Monhoc, Nguoidung> nguoidung;
    public static volatile SingularAttribute<Monhoc, Long> id;
    public static volatile SingularAttribute<Monhoc, String> moTaMonHoc;
    public static volatile SingularAttribute<Monhoc, String> ten;
    public static volatile SetAttribute<Monhoc, Lophoc> lophocSet;

}