package com.callRing.self.po;

import java.io.Serializable;

/**
 * Created by kcz on 2016/5/22.
 */
public class GraphTheory implements Serializable {
    private static final long serialVersionUID = -739848860525422318L;
    public String graphTheoryTittle;
    public String graphTheoryContent;
    public String graphTheoryImagePicPath;
    public String userName;
    public GraphTheory() {

    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGraphTheoryTittle() {
        return graphTheoryTittle;
    }

    public void setGraphTheoryTittle(String graphTheoryTittle) {
        this.graphTheoryTittle = graphTheoryTittle;
    }

    public String getGraphTheoryContent() {
        return graphTheoryContent;
    }

    public void setGraphTheoryContent(String graphTheoryContent) {
        this.graphTheoryContent = graphTheoryContent;
    }

    public String getGraphTheoryImagePicPath() {
        return graphTheoryImagePicPath;
    }

    public void setGraphTheoryImagePicPath(String graphTheoryImagePicPath) {
        this.graphTheoryImagePicPath = graphTheoryImagePicPath;
    }
}
