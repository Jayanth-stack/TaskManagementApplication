import React from 'react';
import { Row, Col, Button } from 'react-bootstrap';

const PageHeader = ({ 
  title, 
  subtitle = '', 
  actionText = '', 
  onActionClick = null,
  actionIcon = null,
  breadcrumbs = null
}) => {
  return (
    <div className="mb-4 pb-2 border-bottom">
      {breadcrumbs && (
        <div className="mb-2">
          {breadcrumbs}
        </div>
      )}
      <Row className="align-items-center">
        <Col>
          <h1 className="mb-1">{title}</h1>
          {subtitle && <p className="text-muted mb-0">{subtitle}</p>}
        </Col>
        {actionText && onActionClick && (
          <Col xs="auto">
            <Button onClick={onActionClick} variant="primary">
              {actionIcon && <span className="me-2">{actionIcon}</span>}
              {actionText}
            </Button>
          </Col>
        )}
      </Row>
    </div>
  );
};

export default PageHeader; 