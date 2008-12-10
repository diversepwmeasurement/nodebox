package net.nodebox.client;

import net.nodebox.node.Node;

import java.awt.*;

public class ParameterPane extends Pane {

    private PaneHeader paneHeader;
    private NetworkAddressBar networkAddressBar;
    private ParameterView parameterView;
    private Node node;

    public ParameterPane(Document document) {
        this();
        setDocument(document);
    }

    public ParameterPane() {
        setLayout(new BorderLayout());
        paneHeader = new PaneHeader(this);
        networkAddressBar = new NetworkAddressBar(this);
        paneHeader.add(networkAddressBar);
        parameterView = new ParameterView();
        add(paneHeader, BorderLayout.NORTH);
        add(parameterView, BorderLayout.CENTER);
    }

    public Pane clone() {
        return new ParameterPane(getDocument());
    }

    @Override
    public void setDocument(Document document) {
        super.setDocument(document);
        if (document == null) return;
        setNode(document.getActiveNode());
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
        networkAddressBar.setNode(node);
        parameterView.setNode(node);
    }

    @Override
    public void activeNodeChangedEvent(Node activeNode) {
        setNode(activeNode);
    }
}