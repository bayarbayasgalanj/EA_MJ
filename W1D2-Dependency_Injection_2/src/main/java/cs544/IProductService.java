package cs544;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public interface IProductService {
	
	public Product getProduct(int productNumber);
	public int getNumberInStock(int productNumber);
	public void setInventoryService(IInventoryService inventoryService);
}
