import React from 'react';
import { Card as BootstrapCard } from 'react-bootstrap';

const Card = ({ title, children, className = '', headerAction = null, footer = null }) => {
  return (
    <BootstrapCard className={`shadow-sm rounded ${className}`}>
      {title && (
        <BootstrapCard.Header className="d-flex justify-content-between align-items-center bg-white border-bottom-0 pt-3 pb-0">
          <BootstrapCard.Title className="mb-0">{title}</BootstrapCard.Title>
          {headerAction && <div>{headerAction}</div>}
        </BootstrapCard.Header>
      )}
      <BootstrapCard.Body>{children}</BootstrapCard.Body>
      {footer && <BootstrapCard.Footer className="bg-white border-top-0">{footer}</BootstrapCard.Footer>}
    </BootstrapCard>
  );
};

export default Card; 