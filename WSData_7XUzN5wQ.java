package client;

public class WSData_7XUzN5wQ {
    public static void main(String[] args) {
        // Khởi tạo Client từ mã sinh tự động CXF
        SoapDataService service = new SoapDataService();
        DataService port = service.getSoapDataServicePort(); // Kiểm tra tên hàm getPort chính xác trong SoapDataService.java

        String studentCode = "B23DCCN762";
        String qCode = "7XUzN5wQ";

        // a. Lấy dữ liệu từ Server
        List<Integer> numbers = port.getData(studentCode, qCode);
        // b. Xử lý dữ liệu
        // c. Gửi kết quả về Server
        port.submitDataString(studentCode, qCode, result);
    }
}