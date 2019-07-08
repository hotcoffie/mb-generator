const entityMaker = {
    get(conf) {
        let text =
            'package ' + conf.pkg + '.entity;\n\n' +
            'import lombok.Data;\n\n' +
            '/**\n' +
            ' * Description: ' + conf.tableComment + '\n' +
            ' *\n' +
            ' * @author ' + conf.author + '\n' +
            ' * Date: ' + conf.date + '\n' +
            ' */\n' +
            '@Data\n' +
            'public class ' + conf.className + ' {\n\n';
        for (let col of conf.cols) {
            if (col.comment) {
                text += '    /**\n' +
                    '     * ' + col.comment + '\n' +
                    '     */\n';
            }
            text += '    private ' + col.type + ' ' + col.name + ';\n\n';
        }
        text += '}';
        return text;
    }
};
