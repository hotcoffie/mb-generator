/*=========================================工具方法==================================*/

//驼峰命名
function camelCase(string) {
    return string.replace(/_([a-z])/g, function (all, letter) {
        return letter.toUpperCase();
    });
}

//生成可下载的文本文件
function download(filename, text) {
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);

    element.style.display = 'none';
    document.body.appendChild(element);

    element.click();

    document.body.removeChild(element);
}
