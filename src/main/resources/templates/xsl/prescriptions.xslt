<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">
    <xsl:output method="html" indent="yes" />
    <xsl:template match="/">
        <html>
            <body>
                <div align="center">
                    <xsl:apply-templates />
                </div>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="prescriptions">
        <table border="1" width="100%">
            <tr bgcolor="#eee">
                <th>Id</th>
                <th>Доктор</th>
                <th>Пациент</th>
                <th>Описание</th>
                <th>Время</th>
                <th>Приоритет</th>
            </tr>
            <xsl:for-each select="prescription">
                <tr>
                    <td>
                        <xsl:value-of select="id"/>
                    </td>
                    <td>
                        <xsl:value-of select="doctor"/>
                    </td>
                    <td>
                        <xsl:value-of select="patient"/>
                    </td>
                    <td>
                        <xsl:value-of select="description"/>
                    </td>
                    <td>
                        <xsl:value-of select="datetime"/>
                    </td>
                    <td>
                        <xsl:value-of select="priority"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>