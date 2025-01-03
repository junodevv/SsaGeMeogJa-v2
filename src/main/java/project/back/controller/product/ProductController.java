package project.back.controller.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.back.dto.ApiResponse;
import project.back.dto.cart.ProductSearchDto;
import project.back.dto.product.ProductDto;
import project.back.service.product.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    /**
     * 상품 목록 페이징 처리해서 가져오기
     */
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDto>>> getAllProductDtos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(productService.findAllProductDtos(page, size));
    }

    /**
     * [GET] productName 을 포함하는 검색한 모든 재료 검색
     *
     * @param productName 상품이름(String)
     * @return 상품이름을 포함하는 모든 재료
     */
    @GetMapping("/{productName}")
    public ResponseEntity<ApiResponse<List<ProductSearchDto>>> findAllByProductName(@PathVariable String productName) {
        return ResponseEntity.ok(productService.findAllByProductName(productName));
    }
}