from pdfminer.pdfinterp import PDFResourceManager, PDFPageInterpreter
from pdfminer.converter import TextConverter
from pdfminer.layout import LAParams
from pdfminer.pdfpage import PDFPage
import os
from io import StringIO
import io

def extract_text_from_pdf(pdf_path):
    with open(pdf_path, 'rb') as fh:
        for page in PDFPage.get_pages(fh, 
                                      caching=True,
                                      check_extractable=True):
            resource_manager = PDFResourceManager()
            fake_file_handle = io.StringIO()
            converter = TextConverter(resource_manager, fake_file_handle, laparams=LAParams())
            page_interpreter = PDFPageInterpreter(resource_manager, converter)
            page_interpreter.process_page(page)
 
            text = fake_file_handle.getvalue()
            return text
 
            # close open handles
            converter.close()
            fake_file_handle.close() 


def invoice_code(search_word,x):

    while(os.path.exists('D:/Comprobantes de pago/NAP000117PT5FA      '+str(x)+'.pdf')|os.path.exists('D:/Comprobantes de pago/NAP000117PT5FA      '+str(x+1)+'.pdf')|os.path.exists('D:/Comprobantes de pago/NAP000117PT5FA      '+str(x+2)+'.pdf')):
        if os.path.exists('D:/Comprobantes de pago/NAP000117PT5FA      '+str(x)+'.pdf'):
            w=extract_text_from_pdf('D:/Comprobantes de pago/NAP000117PT5FA      '+str(x)+'.pdf')
            for y in range(len(search_word)):
                if search_word[y] in w:
                    print('A'+str(x))
                    break
        x=x+1