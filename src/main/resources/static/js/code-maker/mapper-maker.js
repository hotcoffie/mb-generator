const mapperMaker = {
    get(conf) {
        let text =
            '<?xml version="1.0" encoding="UTF-8" ?>\n' +
            '<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >\n' +
            '<mapper namespace="' + conf.pkg + '.' + conf.className + 'Mapper">\n\n' +
            '</mapper>';
        return text;
    }
};
