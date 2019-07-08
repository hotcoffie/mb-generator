const daoMaker = {
    get(conf) {
        let text =
            'package ' + conf.pkg + '.dao;\n\n' +
            '/**\n' +
            ' * Description: ' + conf.tableComment + '\n' +
            ' *\n' +
            ' * @author ' + conf.author + '\n' +
            ' * Date: ' + conf.date + '\n' +
            ' */\n' +
            'public interface ' + conf.className + 'Mapper {\n\n' +

            '}';
        return text;
    }
};
