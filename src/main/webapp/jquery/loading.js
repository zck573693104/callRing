function showLoader() {  
    $.mobile.loading('show', {  
        text: 'loading...', //����������ʾ������  
        textVisible: true, //�Ƿ���ʾ����  
        theme: 'a',        //������������ʽa-e  
        textonly: false,   //�Ƿ�ֻ��ʾ����  
        html: ""           //Ҫ��ʾ��html���ݣ���ͼƬ��  
    });
}  
  
function hideLoader() {
    $.mobile.loading('hide');  
}