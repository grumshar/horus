package pl.dcielicki;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure {

    private List<INode> nodes = new ArrayList<>();

    public INode findByCode(String code) {
        return findByPredicate(node -> node.getCode().equals(code));
    }

    public INode findByRenderer(String renderer) {
        return findByPredicate(node -> node.getRenderer().equals(renderer));
    }

    private INode findByPredicate(Predicate<? super INode> predicate) {
        return this.nodes.stream()
                .flatMap(MyStructure::flatten)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    private static Stream<INode> flatten(INode node) {
        if (node instanceof ICompositeNode) {
            return Stream.concat(Stream.of(node),
                    ((ICompositeNode) node).getNodes().stream().flatMap(MyStructure::flatten));
        }
        return Stream.of(node);
    }

    public int count() {
        return getChildrenNodesCount(this.nodes);
    }

    private static int getChildrenNodesCount(List<INode> nodes) {
        int count = 0;
        for (INode node : nodes) {
            count++;
            if (node instanceof ICompositeNode) {
                count += getChildrenNodesCount(((ICompositeNode) node).getNodes());
            }
        }
        return count;
    }

    public void addNode(INode node) {
        this.nodes.add(node);
    }

}
