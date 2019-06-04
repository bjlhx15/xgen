package com.github.bjlhx15.xgen.output.types.outputtofile.plaintxt;

import com.github.bjlhx15.xgen.output.types.outputtofile.Outter;
import com.github.bjlhx15.xgen.util.file.FileHelper;

public class OutterImpl
  implements Outter
{
  public boolean writeContent(String outPathAndFileName, String content) {
    FileHelper.writeFile(outPathAndFileName, content);
    return true;
  }
}