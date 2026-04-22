from pdfminer.pdfinterp import PDFResourceManager, PDFPageInterpreter
from pdfminer.converter import TextConverter
from pdfminer.layout import LAParams
from pdfminer.pdfpage import PDFPage
import os
from io import StringIO
import io
import numpy as np
import pandas as pd
import xlwings
import time

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

def process_codes(code):
    tmp=code.split('-')
    order=tmp[0]
    number=tmp[1]
    year=tmp[2]
    return order[0:2]+number+year[2:4]
 
def invoice_print(invoices):
    for step in range(len(invoices)):
        if (ws.range('N'+str(step+5)).value=='-') & (invoices[step]!='-'):
            for j in range(len(invoices)):
                tmp2=ot[step].split('-')
                tmp3=tmp2[0]+'-'+tmp2[1]
                if (ws2.range('A'+str(j+3)).value==tmp3):
                    ws2.range('D'+str(j+3)).value=invoices[step]
                    break    

def invoice_code(x, sw1, sw2, fact):
    sw1f=''
    sw2f=''
    invoices=[None]*len(sw1)
    while(os.path.exists('D:/Comprobantes de pago/NAP000117PT5FA      '+str(x)+'.pdf')|os.path.exists('D:/Comprobantes de pago/NAP000117PT5FA      '+str(x+1)+'.pdf')|os.path.exists('D:/Comprobantes de pago/NAP000117PT5FA      '+str(x+2)+'.pdf')):
        if os.path.exists('D:/Comprobantes de pago/NAP000117PT5FA      '+str(x)+'.pdf'):
            w=extract_text_from_pdf('D:/Comprobantes de pago/NAP000117PT5FA      '+str(x)+'.pdf')
            for y in range(len(sw1)):
                if 'A' not in fact[y]:
                    if (sw1[y]!='*'):
                        sw1f=process_codes(sw1[y])
                        if (sw2[y]!='SIN COTIZACIÓN') & (sw2[y]!='-') & (sw2[y]!='SIN COTIZACION') & (sw2[y]!='SIN COT / CANCELADA'):
                            sw2f=process_codes(sw2[y])
                            if sw1f in w or sw2f in w:
                                invoices[y]='A'+str(x)
                            else:
                                if invoices[y] is None or invoices[y]=='-':
                                    invoices[y]='-'
                        else:
                            if sw1f in w:
                                invoices[y]='A'+str(x)
                            else:
                                if invoices[y] is None or invoices[y]=='-':
                                    invoices[y]='-'
                    else:
                        if invoices[y] is None or invoices[y]=='-':
                            invoices[y]='-'
                else:
                    if invoices[y] is None or invoices[y]=='-':
                            invoices[y]='-'
        x=x+1
        
    invoice_print(invoices)

def invoice_main():
    
    wb=xlwings.Book.caller()
    ws=wb.sheets['2020']
    ws2=wb.sheets['Registro']
    x=6039
    
    if 'NDTG' in ws.range('A5').value:
        ot=ws.range('A5:A668').value
        cot=ws.range('I5:I668').value
        fact=ws.range('N5:N668').value
    elif 'INS' in ws.range('A5').value:
        ot=ws.range('A5:A322').value
        cot=ws.range('I5:I322').value
        fact=ws.range('N5:N322').value
    elif 'IMT' in ws.range('A5').value:
        ot=ws.range('A5:A134').value
        cot=ws.range('K5:K134').value
        fact=ws.range('P5:P134').value
    elif 'BDT' in ws.range('A5').value:
        ot=ws.range('A5:A300').value
        cot=ws.range('I5:I300').value
        fact=ws.range('N5:N300').value
    elif 'ISG' in ws.range('A5').value:
        ot=ws.range('A5:A300').value
        cot=ws.range('I5:I300').value
        fact=ws.range('N5:N300').value
    elif 'SNL' in ws.range('A5').value:
        ot=ws.range('A5:A299').value
        cot=ws.range('I5:I299').value
        fact=ws.range('N5:N299').value
    invoice_code(x, ot, cot, fact)