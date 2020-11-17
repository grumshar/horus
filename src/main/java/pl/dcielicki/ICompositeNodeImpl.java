package pl.dcielicki;

import java.util.ArrayList;
import java.util.List;

public class ICompositeNodeImpl implements ICompositeNode {

    private String code;
    private String renderer;
    private List<INode> nodes = new ArrayList<>();

    public ICompositeNodeImpl(String code, String renderer) {
        this.code = code;
        this.renderer = renderer;
    }

    public void addNode(INode node) {
        this.nodes.add(node);
    }

    @Override
    public List<INode> getNodes() {
        return this.nodes;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getRenderer() {
        return this.renderer;
    }

    @Override
    public String toString() {
        return "ICompositeNodeImpl{" +
                "code='" + code + '\'' +
                ", renderer='" + renderer + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
