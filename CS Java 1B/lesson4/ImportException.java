// Project: ImportException
// Author: Indira Mariya
// Throws exception if non-matching or failed imports found.
import java.io.IOException;

public class ImportException extends IOException {
   int failCount = 0;
   
   public ImportException(int failCount) {
      super(failCount + " non-matching or failed imports");
      this.failCount = failCount;
   }
}