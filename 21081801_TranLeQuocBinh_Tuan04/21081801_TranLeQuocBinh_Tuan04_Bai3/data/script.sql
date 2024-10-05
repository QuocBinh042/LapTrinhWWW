CREATE DATABASE QUANLYDANHMUC

INSERT INTO DanhMuc (ghiChu, nguoiQuanLy, tenDanhMuc) VALUES
('Danh muc the thao', 'Nguyen Van A', 'The thao'),
('Danh muc cong nghe', 'Tran Thi B', 'Cong nghe'),
('Danh muc giai tri', 'Le Van C', 'Giai tri'),
('Danh muc giao duc', 'Pham Van D', 'Giao duc'),
('Danh muc suc khoe', 'Ngo Thi E', 'Suc khoe');

INSERT INTO TinTuc (lienKet, noiDungTT, tieuDe, maDM) VALUES
('http://thethao.example.com', 'Noi dung ve the thao', 'Bai viet the thao', 1),
('http://congnghe.example.com', 'Noi dung ve cong nghe', 'Bai viet cong nghe', 2),
('http://giaitri.example.com', 'Noi dung ve giai tri', 'Bai viet giai tri', 3),
('http://giaoduc.example.com', 'Noi dung ve giao duc', 'Bai viet giao duc', 4),
('http://suckhoe.example.com', 'Noi dung ve suc khoe', 'Bai viet suc khoe', 5);